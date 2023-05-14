# imports
import requests
from bs4 import BeautifulSoup
from textblob import TextBlob

# David White
# 2023/04/03
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Exercise 12.2
# Description:
# Using the text from Exercise 12.1, create a TextBlob, then tokenize it into Sentences and Words, 
# and extract its noun phrases

# get web page
response = requests.get('https://www.python.org')

# get text from web page
soup = BeautifulSoup(response.text, 'html.parser')
text = soup.get_text(strip=True)

# make text blob
blob = TextBlob(text)

# tokenize into sentences
print(f'Sentences: \n{blob.sentences}\n\n')

# tokenize into words
print(f'Words: \n{blob.words}\n\n')

# noun phrases
print(f'Nouns: \n{blob.noun_phrases}')