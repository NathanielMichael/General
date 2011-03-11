General 4.0 - Plugin for CraftBukkit
=========================

First of All
---------------

Thanks for your interest in the General plugin, a lot of time and effort has been spent on this project and a lot of thought has gone in to the way we do things, if you like it we encourage you to come join us at [Craftstars](http://craftstars.net) to help make amazing software.

You can find us on IRC at:

    irc.esper.net #craftstars

Credit Where Credit is Due
--------------------------------------

This project couldn't have happened without the amazing and talented people we have the privilege of working with every day.

**First and Foremost**: [Mojang](http://mojang.com/)
Creators of Minecraft. None of us would be here without them.

[Bukkit Team](http://bukkit.org):
The Bukkit team has done something very amazing, saw potential and purpose and created something wonderful.

**Ninjikokun**:
Original author of General, you are a wizard my friend.

**Craftstars**:
Current authors and maintainers of this project.
 * CelticMinstrel
 * Plutonium239 (Nate Michael) (http://nate.aero)

**Others**:
 * ?

Build Instructions
-------------------------
Requirements:
 * [Apache Ant](http://ant.apache.org)
 * [Ivy](http://ant.apache.org/ivy) (Optional; as our build now grabs this automatically)

### Step 1: Get the source ###
If you're reading this chances are you already have a copy of the source files, if so you can skip to step 2, otherwise you can find it at [GitHub](https://github.com/craftstars/General). You can either download a tar or zip file of the source or checkout using Git. If you plan on contributing back to the project you should create an account on GitHub and fork the repository so that you can make changes. All this is explained in great detail here: [Forking a repo](http://help.github.com/fork-a-repo/). If you just want to build the plugin or don't plan on contributing your changes back (sad) then this will work fine for you:
 
    git clone git://github.com/craftstars/General.git

### Step 2: Installing Ant ###

If you already have Ant installed, skip to step 3. Follow the instructions below to install Ant for your platform.

Installing Apache Ant: http://ant.apache.org/manual/install.html
Installing Ant on Windows: [Install Ant on Windows](http://omrudi.wordpress.com/2008/11/08/how-to-install-ant-in-windows-xp/)

### Step 3: Build! ###

Once you have the source and Ant installed, cd in to the directory you have the source checked out in to and run:

    ant jar

This will create the *dist* directory and the *General.jar* file. That's it! Done!

If you make changes to the source just run 'ant jar' again and the jar file will be updated with your changes.
