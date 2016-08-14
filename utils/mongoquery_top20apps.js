// This script contains mongo commands to extract app records
// To run this script, in command window (not mongo prompt)
// mongo appstore --quiet < mongoquery.js > ../data/temp/top20apps.json
// --quiet will suppress other mongodb output, keeping just the results

db.appinfo.find().sort({"score": -1}).limit(20)
