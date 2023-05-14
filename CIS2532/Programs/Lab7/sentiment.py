# imports
import requests
from bs4 import BeautifulSoup
from textblob import TextBlob

# David White
# 2023/04/03
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Exercise 12.3
# Description:
# Using the techniques in Exercise 12.1, download a web page 
# for a current news article and create a TextBlob. Display the 
# Sentiment for the entire TextBlob and for each Sentence.

# get web page
url = 'https://www.theonion.com/it-is-journalism-s-sacred-duty-to-endanger-the-lives-of-1850126997'
response = requests.get(url)

# get text from web page
soup = BeautifulSoup(response.text, 'html.parser')
text = soup.get_text(strip=True)

# make text blob
blob = TextBlob(text)

# get setement for entire article
print(f'Sentement for Entire Article: {blob.sentiment}')

# get sentement for each sentance
print(f'Sentement of each sentance:')

for sentance in blob.sentences:
    print(sentance.sentiment)