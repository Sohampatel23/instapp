
# instagram Application

A spring boot application to integrated with JPA repository with mapping fuctionality and valid sign up.


## Data Flow

1. insta Main Application File
2. user,post,auth Controller class which is Autowired
3. user,post,auth Model class with entities
4. user,post,auth Service class extending Repo class
5. user,post,auth Repo class extend JPA Repository 
6. Mapping functionality and enum class
7. Mail the toke to user

## Data Structure

List structure to show data

## Summary

Whole Project is built in spring boot application with IDE of Intellij Idea. Which contains controller class configured with model class to provide data source and Service which has actual logic to API's which can be tested on localhost of your own PC.
And also Repo class extends CrudRepository for to simplify database operations
