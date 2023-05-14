# David White
# 9/26/2022
# CIS-2531
# Instructor: Carolyn England
# Assignment: Write Baseball Stats
# Description:
# Create a Python program to save the following player statistics for the home
# baseball team:
# Player Name
# Games Played
# Home Runs
# Batting Average
# Prompt and read the above data for a user defined number of players. Write the
# data out ot a sequential ASCII text file.

def get_games_played():
    try:
        games_played = int(input("Enter the number of games played: "))
    except ValueError:
        print('ERROR: NON INTEGER VALUE ENTERED')
        exit(1)
    else:
        if games_played <= 0:
            print('ERROR: NEGATIVE NUMBER ENTERED!')
            exit(2)
        return games_played


def get_home_runs():
    try:
        HR = int(input("Enter the number of Home Runs: "))
    except ValueError:
        print('ERROR: NON INTEGER VALUE ENTERED')
        exit(1)
    else:
        if HR <= 0:
            print('ERROR: NEGATIVE NUMBER ENTERED!')
            exit(2)
        return HR


def get_bat_avg():
    try:
        avg = float(input("Enter the player's batting average: "))
    except ValueError:
        print('ERROR: NON FLOAT VALUE ENTERED')
        exit(1)
    else:
        if avg <= 0:
            print('ERROR: NEGATIVE NUMBER ENTERED!')
            exit(2)
        return avg


def write_stats(out_file, name, games_played, home_runs, bat_avg):
    out_file.write(f'{name}\n')
    out_file.write(f'{games_played}\n')
    out_file.write(f'{home_runs}\n')
    out_file.write(f'{bat_avg}\n')


def main():
    try:
        # ask user for number of player statistics
        num_players = int(input("Enter the number of player statistics to record: "))
    except ValueError:
        print('ERROR: NON INTEGER VALUE ENTERED')
        exit(1)
    else:
        if num_players <= 0:
            print('ERROR: NEGATIVE NUMBER ENTERED!')
            exit(2)

    try:
        file_name = input("Enter the file location to save to: ")
        out_file = open(rf'{file_name}', 'w')

        for i in range(num_players):
            name = input("Enter name of Player: ")
            games_played = get_games_played()
            home_runs = get_home_runs()
            bat_avg = get_bat_avg()
            write_stats(out_file, name, games_played, home_runs, bat_avg)

        out_file.close()
        print(f"Data saved to {file_name}")

    except FileNotFoundError:
        print('ERROR: FILE NOT FOUND!')
        exit(3)


if __name__ == "__main__":
    main()


# Enter the number of player statistics to record: 4
# Enter the file location to save to: D:\stats.txt
# Enter name of Player: Seiya Suzuki
# Enter the number of games played: 104
# Enter the number of Home Runs: 13
# Enter the player's batting average: .263
# Enter name of Player: Willson Contreras
# Enter the number of games played: 107
# Enter the number of Home Runs: 21
# Enter the player's batting average: .246
# Enter name of Player: Ian Happ
# Enter the number of games played: 149
# Enter the number of Home Runs: 17
# Enter the player's batting average: .270
# Enter name of Player: Patrick Wisdom
# Enter the number of games played: 127
# Enter the number of Home Runs: 25
# Enter the player's batting average: .210
# Data saved to D:\stats.txt
