# Appstore719
Bittiger's 5th project team

## Data
Raw data provided by bitTiger in MySQL format is loaded and converted into a MongoDB format.
### Restore
MongoDB database has been dumped into a backup file and it can be restored easily using the following command.
```bash
mongorestore --db appstore DIRECTORY_PATH_TO_DUMPED_FILE
```
### Dump into a backup
```bash
mongodump --db appstore --out DIRECTORY_PATH_TO_DUMPED_FILE
```




