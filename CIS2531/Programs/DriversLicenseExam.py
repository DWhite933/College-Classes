import matplotlib.pyplot as plt
# David White
# 10/3/2022
# CIS-2531
# Instructor: Carolyn England
# Assignment: Programming Exercise #7: Driver's License Exam
# Description: A grading application for a Driver's License Exam


def get_student_answers():
    # ask user for file name
    file_Name = input("Enter the test data file name: ")

    try:
        # open file for reading
        inf = open(file_Name, 'r')
    except FileNotFoundError:
        print('ERROR: File not found.')
        exit(1)
    else:
        # read file contents into list
        answers = inf.readlines()

        # close file
        inf.close()

        # strip new line
        for i, v in enumerate(answers):
            answers[i] = answers[i].rstrip('\n')

        return answers


def grade_answers(answers):
    # Tuple to Hold the Correct Answers
    correct_Answers = (
        'A', 'C', 'A', 'A', 'D', 'B', 'C', 'A', 'C', 'B', 'A', 'D', 'C', 'A', 'D', 'C', 'B', 'B', 'D', 'A')

    # list to hold correct answers
    student_Correct = []

    # list to hold Incorrect answers
    student_Incorrect = []

    for i in range(len(correct_Answers)):
        if correct_Answers[i].upper() == answers[i].upper():
            student_Correct.append(i+1)
        else:
            student_Incorrect.append(i+1)
    return student_Correct, student_Incorrect


def pie_chart(pie_list):
    # list of labels for slices
    slice_labels = ['Correct Answers', 'Incorrect Answers']

    # create pie pie_chart
    plt.pie(pie_list, labels=slice_labels, autopct='%1.1f%%', colors=('g', 'r'))

    # add title
    plt.title('Driver\'s License Exam')

    # show pie chart
    plt.show()


def main():
    # List to hold student answers
    student_Answers = get_student_answers()

    # list to hold the question number of correct and incorrect answer
    student_Correct, student_Incorrect = grade_answers(student_Answers)

    # show user text info
    if len(student_Correct) >= 15:
        print("You passed the exam! 😁")
    else:
        print("You failed the exam. 😪")

    print(f'Answers Correct: {len(student_Correct)}')
    if len(student_Correct) > 0:
        print(f'Questions: {student_Correct}')

    print()
    print(f'Answers Incorrect: {len(student_Incorrect)}')

    if len(student_Incorrect) > 0:
        print(f'Questions: {student_Incorrect}')

    # list for the pie chart
    pie_list = [len(student_Correct), len(student_Incorrect)]

    # create pie chart
    pie_chart(pie_list)


if __name__ == "__main__":
    main()
