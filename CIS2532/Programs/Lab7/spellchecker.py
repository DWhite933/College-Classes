# imports
from textblob import TextBlob, Word
from pathlib import Path

# David White
# 2023/04/03
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Exercise 12.5
# Description:
# Download a Project Gutenberg book and create a Text Blob. Tokenize
# the Text blob into Words and determine whether any are misspelled.
# If so, display the possible corrections.

# According to the textblob API reference the spell checker is
# only 70% accurate, so some correctly spelled words will get 
# throught the spell checker.
# https://textblob.readthedocs.io/en/dev/quickstart.html#id2

# read file
txt = Path('36-0.txt').read_text(encoding='utf-8')

#get text blob
blob = TextBlob(txt)

for i,v in enumerate(blob.words):#[0:1000]):
    lowered = Word(v.lower())
    check = lowered.spellcheck()[0][1]
    if check < 1.0 and check != 0.0:
        print(f'Misspelled Word!: {v} \n'
              f'Suggested words = {Word(v.lower()).spellcheck()[0:3]}\n')


