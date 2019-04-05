# Japanagram 
## An Instagram like blog for the Japan trip.

## Requirements : 
#### key : 
* \<TYPE\> - indicates the type of request or db table. 
* {filename.jsp} - indicates the name of the jsp to be returned.

### - Route's
* \<GET\> /admin/login - a route to return the login screen for poster {login.jsp}.
* \<POST\> /admin/login?username=something&password=something - a route for receiving form input to login. Will use a form not query parameters. Redirect to /admin if successful {admin.jsp} with username as redirect variable else redirect to login with redirect variable indicating a failed login {login.jsp}.
* \<GET\> /admin?username=username - return the page for admins to make posts. username is the username of the logged in admin {admin.jsp}.
* \<POST\> /admin/upload?files=filenames&title=title&description=description&username&username - a route to upload new posts during the trip. Will be able to upload multiple images at once. Redirect to /admin {admin.jsp} if successful else return 500 error.  
* \<GET\> / - The home page where post's will be shown {home.jsp}. 
* \<GET\> /posts - return json of the posts and post information sorted by date.
* \<POST\> /about - returns an about simple page {about.jsp}.
* \<GET\> /error - an error route to display generic errors to the user {error.jsp}.

### - Database
* \<Database\> japanagram - a database to hold this projects tables.
* \<User\> japanagram - a user who has full access to japanagram.
* \<Table\> user(username,password,date_created) - stores admin users (username is primary key).
* \<Table\> post(id,date_created,title,description) - table to hold posts (id is primary key).
* \<Table\> post_asset(id,post_id,url) - holds location of images on filesystem (id is primary key, post_id is foreign key to the post table).

### - DAO's 
* UserDao - handle queries for users.
* PostDao - handle queries for posts.

### - Service's
* FileSystem - a service for storing images on the the servers filesystem. 

### - Security
* Sessions - implement sessions to keep track of logged in admin users. 
* Security - implement spring security to use sessions for restricting routes and content on the admin side.

### - Frontend 
* Bootstrap 4 - used for styling.
* Jquery - used with bootstrap for some nice functionality. 

## Git flow :
* Two branchs (master,develop). All work is done on develop and merged into master after all issues in a pull request are complete.
* Make smallish frequent commits (logical units of work).
* When a chunk of work is complete (you completed a controller, added sessions and security etc...) make a pull request in github from develop into master. 
* Once all issues (if any) are taken care of, switch to master, do a git pull, then git merge develop, and finally git push origin master. 