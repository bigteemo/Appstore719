// Command to run this query file
// mongo appstore --quiet < query_relatedapps.js > ../data/temp/related5.json
db.appinfo.find({"appid":{"$in": ["C20252", "C6015363", "C10196888", "C10114178", "C2217"]}})
