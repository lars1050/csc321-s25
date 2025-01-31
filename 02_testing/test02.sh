#!/bin/sh

# file containing team member information
teamfile="collaborators.txt"

# current working directory to cd back to
cwd=$(pwd)

# every folder in this folder ...
for folder in *
do
    # if it is a folder (not a file)
    if [ -d "$folder" ]; then
        
        # move into the folder and check has name looking for
        cd "$folder"
        if [ -d "02_git_collaborations" ]; then

            # make sure we have the latest
            git pull
            
            # run the code to confirm it is working
            cd 02_git_collaborations
            rm *.class
            javac Main.java
            java Main

            # read file with team member info
            while read line; do

                # strip last linefeed chars and split by comma
                line=$(echo "$line" | tr -d '\r\n')
                IFS=',' read -ra fields <<< "$line"

                # output member info to terminal
                echo ""
                printf "MEMBER: ${fields[0]}, ${fields[1]}, ${fields[2]}\n"

            done < "$teamfile"
        fi
    fi
    # back to the original folder
    cd "$cwd"
done
