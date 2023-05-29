#!/bin/bash

RED='\033[0;31m'
NC='\033[0m'
ERROR=${RED}ERROR${NC}

echo
printf "Choose an option [1-3] \n"
echo "-------------------------------------------"
echo "| 1 : Deliver UAT                          |"
echo "| 2 : Deliver Production                   |"
echo "| 3 : Exit                                 |"
echo "-------------------------------------------"
echo -n "Please choose a number : "

read optionmenu
echo
        case $optionmenu in
        1)
                echo "Delivering UAT ..."
                git tag --force uat && git push --force origin uat
                exit;;
        2)
                echo "Delivering Prod ..."
                echo -n "> Please select a version number ( for example 1.2.3 ) : "
                read version
                if [[ "$version" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]];then
                        git tag $version -am "Building the corporate version $version" && git push origin $version
                else
                        printf "${ERROR} : Version must follow this regular expression [digit].[digit].[digit], for example 1.2.3\n"
                        exit
                fi
        ;;

        3)
                exit;;
        *)
                printf "${ERROR} : Bad choice (°_°), Please retry again ...\n"
                exit;;
        esac