import mysql.connector
from pymongo import MongoClient

def convertToMongoDB:
    '''
    Convert the App info database from .sql file into a MongoDB collection (appstore.appinfo)
    '''
    connection = mysql.connector.connect(user='root',host='127.0.0.1',database='appstore')
    cursor = connection.cursor()
    query = "SELECT appid, score, title, url, thumbnail_url, intro, developer, top5App from app_info"
    cursor.execute(query)
    client = MongoClient()
    db = client.appstore
    for appid, score, title, url, thumbnail_url, intro, developer, top5App in cursor:
        temp = ({'appid': appid, 'score': score, 'title': title, 
                 'url': url, 'thumbnail_url': thumbnail_url, 'intro': intro, 'developer': developer, 'top5App': top5App})
        db.appinfo.insert_one(temp)

if __name__ == "__main__":
    convertToMongoDB()


