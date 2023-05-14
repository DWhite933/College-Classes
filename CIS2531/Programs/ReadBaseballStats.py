# David White
# 9/26/2022
# CIS-2531
# Instructor: Carolyn England
# Assignment: Read Baseball Stats
# Description: Create a Python program to read and display the following player statistics for the
# home baseball team:
# Player Name
# Games Played
# Home Runs
# Read the above data for an indeterminate number of players from a data file
# Using python formatting functions/methods, generate a team player report that includes the above data
# for each player as well as summary line that include the total number of players, the average number of
# games played, and the average number of home runs

def show_info(name, games_played, home_runs):
    print(f'{name:<25}{games_played:<16}{home_runs}')


def main():
    file_name = input("Enter file name: ")
    num_players = 0
    total_games = 0
    total_hr = 0
    total_avg = float(0)

    try:
        inf = open(file_name, 'r')
    except FileNotFoundError:
        print('ERROR: FILE NOT FOUND!')
        exit(1)
    else:
        print(f"Player Name \t\t Games Played \t Home Runs")
        name = inf.readline().rstrip('\n')
        
        while name != '':
            games_played = int(inf.readline())
            total_games += games_played
            home_runs = int(inf.readline())
            total_hr += home_runs
            bat_avg = float(inf.readline())
            total_avg += bat_avg
            show_info(name, games_played, home_runs)
            name = inf.readline().rstrip('\n')
            num_players += 1
        print('***SUMMARY***')
        print(f'Number of players = {num_players}')
        print(f'Average number of games played: {total_games / num_players:.3f}')
        print(f'Average number of Home Runs: {total_hr / num_players:.3f}')
        print(f'Team Batting avg: {total_avg / num_players:.3f}')
        inf.close()


if __name__ == "__main__":
    main()

# Enter file name: stats.txt
# Player Name 		 Games Played 	 Home Runs
# Seiya Suzuki             104             13
# Willson Contreras        107             21
# Ian Happ                 149             17
# Patrick Wisdom           127             25
# ***SUMMARY***
# Number of players = 4
# Average number of games played: 121.750
# Average number of Home Runs: 19.000
# Team Batting avg: 0.247
