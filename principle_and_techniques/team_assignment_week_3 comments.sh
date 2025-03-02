#!/bin/bash

# We defined the directory where the GPX files are located, the backup where the original files are stored, 
# and the directory that holds the organized activity types
SOURCE_DIR="/Users/natekingsbury/Desktop/Strava"
BACKUP_DIR="$SOURCE_DIR/backup"
ACTIVITY_DIR="$SOURCE_DIR/activities"
SUMMARY_FILE="$SOURCE_DIR/summary.txt"

# Printing the directory paths 
echo "Source Directory: $SOURCE_DIR"
echo "Backup Directory: $BACKUP_DIR"
echo "Activity Directory: $ACTIVITY_DIR"

# Create summary file and write header
echo "Activity Name | Start Time | Number of Epochs" > "$SUMMARY_FILE"

# Error checking to make sure the backup directory exists
if [ ! -d "$BACKUP_DIR" ]; then
# -d checks if the directory exists, so we don't make write into a 
# directory that doesn't exist
    echo "Creating backup directory..."
    mkdir -p "$BACKUP_DIR" # Creates a backup directory
    # -p tells mkdir to create the parent directory if it doesn't exist,
    # and it doesn't throw an error if the directory already exists
    echo "Backup directory created."
else
    echo "Backup directory already exists."
fi

# Error checking to make sure the activity directory exists
if [ ! -d "$ACTIVITY_DIR" ]; then
    echo "Creating activity directory..."
    mkdir -p "$ACTIVITY_DIR"
    echo "Activity directory created."
else
    echo "Activity directory already exists."
fi

# The for loop iterates over every GPX file from the source directory with the name Track-*.gpx
for file in "$SOURCE_DIR"/Track-*.gpx; do
    if [ -f "$file" ]; then
        echo "Processing file: $file"
        # if the file exists, then the loop continues
        number=$(echo "$file" | grep -o '[0-9]\+') 
        # Extracts the number from the file name ie 1 from Track1
        new_name="activity-$number.gpx"  
        # renames the file based on the extracted number
        echo "Extracted number: $number"
        echo "Renaming to: $new_name"

        # This copies the original GPX file to the backup directory, so we have a 
        # copy of all the original files instead of writing over them
        cp "$file" "$BACKUP_DIR/" || { echo "Failed to copy $file"; continue; }
        # cp copies the file from one place to another
        echo "Copied $file to backup directory."
        # The failure handling with the || is there to tell us if the copy fails
        # but the code still moves onto the next file in the loop. This gives us
        # readable feedback in case we run into issues like disc space, or 
        # file permissions, etc. 

        # Renaming the file from Track-*.gpx to Activity-*.gpx (problem 1)
        mv "$file" "$SOURCE_DIR/$new_name" || { echo "Failed to rename $file"; continue; }
        echo "Renamed $file to $new_name."
        # Again, the error check moves on so we avoid breaking the entire loop if one
        # file cannot be renamed

        # Extract the activity type (cycling, running, hiking, unknown)
        activity_type=$(grep -o '<type>.*</type>' "$SOURCE_DIR/$new_name" | sed 's/<\/\?type>//g')
                             # Extracts everything in between the <type><type>
        # Grep -o only returns the portion that matches, which is the text in between
        # the type tags. Sed gets rid of the XML tags and leaves just the activity type
        echo "Activity type: $activity_type"

        # If the activity type is empty, set it to "Unknown"
        # The activity in Track 4 was labeled unknown
        if [ -z "$activity_type" ]; then
        # -z checked is a string has zero length
            activity_type="Unknown"
        fi

        # Creates a directory for the unknown data type if it doesn't already exist
        mkdir -p "$ACTIVITY_DIR/$activity_type"
        # The -p makes sure the command won't fail if the directory was already made

        # Move the renamed file to the corresponding activity directory
        # The renamed activity-*.gpx files will be sorted based on their activity 
        # labeled in between <type><type> 
        mv "$SOURCE_DIR/$new_name" "$ACTIVITY_DIR/$activity_type/" || { echo "Failed to move $new_name"; continue; }
        echo "Moved $new_name to $ACTIVITY_DIR/$activity_type/."
        # the failure handling makes sure that if the operation fails, because of file 
        # permission or any other problems, the loop continues

        # Extract the start time from the first occurrence of the <time> tag
        start_time=$(grep -m 1 "<time>" "$ACTIVITY_DIR/$activity_type/$new_name" | sed 's/<\/\?time>//g')
        # grep -m 1 "time" looks for the first occurence of the time tag, so we can know 
        # the start time of the activity
        # The sed 's/<\/\?time>//g' gets rid of everything that is not the timestamp
        # We are only looking for the data inside the XML tag, which is the data enclosed
        # in between the <>. They come in pairs, with an opening tag and a closing tag.
        # 
        if [ -z "$start_time" ]; then
            start_time="Unknown"
            # if no start time is found, unknown is set
        fi
        echo "Start time: $start_time"

        # Count the number of epochs (track points)
        num_epochs=$(grep -c "<trkpt" "$ACTIVITY_DIR/$activity_type/$new_name")
        # epochs aka <trkpt>
        # an epoch is a specific timestamp when a GPS reading is taken
        # in our files, the epoch was contained within <trkpt> and <time> 
        # Each trackpoint has a single recorded GPS point, or an epoch
        echo "Number of epochs: $num_epochs"

        # Appends the details into a structured file 
        echo "$new_name | $start_time | $num_epochs" >> "$SUMMARY_FILE"

    else
        echo "$file does not exist."
    fi
done

# Sort the summary.txt by the number of epochs (3rd column) in descending order
sort -k3 -nr "$SUMMARY_FILE" -o "$SUMMARY_FILE"
# -k3 specifies that we are sorting the thrid column
# -nr tells sort to use numerical sorting, and to sort in reverse order
# -o "$SUMMARY_FILE" puts the sorted data back into the original file

echo "Script completed. Summary file saved to $SUMMARY_FILE."
# Tells us the the script is finished and the final txt file has been saved

# We included error handling throughout the code so the code is fault-tolerant.
# Instead of haulting the process, an error will print a message that we can handle
# after it's done running. 
