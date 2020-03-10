# AutotestsVK

### Description repository
In this repository, autotests for [Bookmark section of the VKontakte site] (vk.com/bookmarks) are implemented. Autotests are written taking into account critical bookmarks for check cases. The main covered functionalities are adding content (Posts, Podcasts, Users, Groups) to bookmarks, adding tags to content in bookmarks, adding new tags, as well as deleting and changing them.

### Stack
Java + Junit + Maven


### How to run autotests on your computer

** There are two ways to run autotests: **

1) Run through the command line, setting the path to the web driver.
> mvn start test -Dwebdriver.chrome.driver = / Users / yana.lunts / Downloads / chromedriver

Where /Users/yana.lunts/Downloads/chromedriver is the path to the web driver that is on your computer.

2) You can specify the path to the driver in VM options when starting the test itself (edit configurate -> VM options -> -Dwebdriver.chrome.driver = / Users / yana.lunts / Downloads / chromedriver)

Where /Users/yana.lunts/Downloads/chromedriver is the path to the web driver that is on your computer.

** The web driver must be the same version as the chrome. **
