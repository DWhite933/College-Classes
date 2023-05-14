# imports
import requests
from bs4 import BeautifulSoup
from wordcloud import WordCloud

# David White
# 2023/04/03
# CIS-2532
# Instructor: Mohammad Morovati
# Assignment: Exercise 12.1
# Description:
# Web pages are excellent sources of text to use in NLP tasks. In the
# following IPython session, you’ll use the requests library to download
# the www.python.org home page’s content. This is called web scraping. You’ll
# then use the Beautiful Soup library to extract only the text from the page.
# Eliminate the stop words in the resulting text, then use the wordcloud module to
# create a word cloud based on the text.

# get web page
response = requests.get('https://www.python.org')

# get text from web page
soup = BeautifulSoup(response.text, 'html.parser')
text = soup.get_text(strip=True)

# create word cloud
cloud = WordCloud(colormap='prism', background_color='white')
cloud = cloud.generate(text)
cloud.to_file('python.png')