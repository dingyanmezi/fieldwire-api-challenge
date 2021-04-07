# API - Floorplans

**Note**: This API is used once, on startup, by each storage server.

Naming Server Host Name: localhost  
Naming Server Registration Port: 8090  
In all cases, if the API call receives invalid data (there is error when parse the request), always return `400 Bad Request`.

------

## GetFloorplan

**Description**: Obtain the floorplan of a specific project

> The storage server notifies the naming server of the files that it is hosting.  
> Note that the storage server does not notify the naming server of any directories.  
> The naming server attempts to add as many of these files as possible to its directory tree.  
> The naming server then replies to the storage server with a subset of these files that the storage server must delete from its local storage.  

> After the storage server has deleted the files as commanded,  
> it must prune its directory tree by removing all directories under which no files can be found.  
> This includes, for example, directories which contain only empty directories.  

> Registration requires the naming server to lock the root directory for exclusive access.  
> Therefore, it is best done when there is not heavy usage of the filesystem.

### request

**URL** : `/projects/1/floorplans`

**Method** : `GET`

**Input Data** :

```json
{
    
}
```

### response_1

**Code** : `200 OK`

**Content** :

```json
{
    "files": [
        "/storage/dir1/dir2/fileC",
        "/file"
    ]
}
```

*files*: return a list of duplicate files to delete on the local storage of the registering storage server.  
(Please refer to the corresponding java class jsonhelper/FilesReturn.java)

### response_2

**Code** : `409 Conflict`

**Content** :

```json
{
    "exception_type": "IllegalStateException",
    "exception_info": "This storage client already registered."
}
```

*exception_type*:

1. IllegalStateException. If the path is invalid.

*exception_info*: for your own debug purpose.  
(Please refer to the corresponding java class jsonhelper/ExceptionReturn.java)




## Create

**URL** : `/projects/1/floorplans`

**Method** : `POST`

**Input Data** :

```json
{
   "img": "file=@/mnt/c/Users/XXX/Pictures/XXX.png"
}
```

### response_1

**Code** : `200 OK`

**Content** :

```json
{
    "files": [
        "/storage/dir1/dir2/fileC",
        "/file"
    ]
}
```

*files*: return a list of duplicate files to delete on the local storage of the registering storage server.  
(Please refer to the corresponding java class jsonhelper/FilesReturn.java)



## Update

**URL** : `/projects/1/floorplans/1`

**Method** : `PATCH`

**Input Data** :

```json
{
   "img": "file=@/mnt/c/Users/XXX/Pictures/XXX.png",
   "name": ""
}
```

### response_1

**Code** : `200 OK`

**Content** :

```json
{
    "files": [
        "/storage/dir1/dir2/fileC",
        "/file"
    ]
}
```

*files*: return a list of duplicate files to delete on the local storage of the registering storage server.  
(Please refer to the corresponding java class jsonhelper/FilesReturn.java)

## delete

**URL** : `/projects/1/floorplans/1`

**Method** : `DELETE`

**Input Data** :

```json
{
   "img": "file=@/mnt/c/Users/XXX/Pictures/XXX.png",
   "name": ""
}
```

### response_1

**Code** : `200 OK`

**Content** :

```json
{
    "files": [
        "/storage/dir1/dir2/fileC",
        "/file"
    ]
}
```

*files*: return a list of duplicate files to delete on the local storage of the registering storage server.  
(Please refer to the corresponding java class jsonhelper/FilesReturn.java)

