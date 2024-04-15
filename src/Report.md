# Blackit (best Version of reddit)
## Description
This is a terminal version of reddit, with fewer and more practical options and a different name. As you should know, in this app you can make different posts based on topics, comment posts and even react them.
Users can join subBlackits (as subreddits in real app) and make posts there.

## Dependencies
- Java SE runtime 8 or later
- Gradle as package manager

## Installing
- Clone the app in [github](https://github.com/MmdHosain/Blackit)
- Download java from [Oracle](https://www.oracle.com)

# About this app

## Usage

- In each menu, you can access options by entering a number ; be careful to only enter allowed number or app will crash!!!
- First you should signUp in the program, entering a **real** E-mail and a secure password.
- User menu contains options like show posts, using dashboard  and search menu.
- you can search for sub Blackit , Accounts ,and posts.
- For creating a post, go to personal menu ad find the option, make a topic and then enter the body of your post.
- creating sub Blackit is on personal menu. Admins have access to add new admins, to do so use admin sub Blackit option.
- there is a simple guid for how to see posts and scroll them.

## Classes

### Main class
- First you enter the program, you have Login and Signup options. When you enter the dashboard there are 11 options which are visible in "user menu".
- user menu: In this menu you can see username, your total karma and options below
  1. Search menu
       > search for accounts sub Blackits and posts. for topic and enter empty to show all the shit    
  2. personal menu
  3. show posts
       > Show posts from new to old from Sub blackits you have joined
  
- in personal menu you can do any action in related to your personal account
  1. account
      >    manage account information
  2. joined sub blackits
      >    show all the sub blackits that you have joined . you can unjoin them here
  3. admin sub blackits
      >    show all the sub blackits that you have created .you can add new post and make new admins .you can join them here too.
  4. create post 
      >    find sub black it you want to add post in and you are good to go.
  5. create sub Blackit 
      >    this is where you can make more subs
### Account
- account class
- this class is heavy so be careful
- any account hase unique id and user name
- password is hashed for farther security :)
- this class handles an account and keeps information of what it is interacted to such as posts and subs
- 

### Post
- the whole point of Blackit is to sho posts
- it hase title and body
- it can hold comments
- it can be deleted and body and title will be replaced with "deleted"
- showing of a single post get don in this class 


### Sub(sub Blackit)
- Contains all the information about each sub
- karma is sum of karma of posts
- showing post scroller gets done in here 






## In the PROCESS...(Challenges & ideas)
- no problemo amigo

## Credits
- resources:
  - [StackOverflow](https://stackoverflow.com)
  - [GeekForGeeks](https://www.geeksforgeeks.org)
  - [JavaTpoint](https://www.javatpoint.com)
- libraries
  - java.util.ArrayList
  - java.util.List
  - java.util.Scanner
  - java.util.UUID
  - java.util.regex.Matcher
  - java.util.regex.Pattern
  - java.util.Objects;
  - java.io;
  - java.util

