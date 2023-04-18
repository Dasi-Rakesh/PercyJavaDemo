# PercyJavaDemo

### Initial Steps

Sign in to Percy and create a new project. You can name the project "todo" if you'd like. After
you've created the project, you'll be shown a token environment variable.

### Step 3

In the shell window you're working in, export the token environment variable:

**Unix**

``` shell
$ export PERCY_TOKEN="<your token here>"
```

**Windows**

``` shell
$ set PERCY_TOKEN="<your token here>"

# PowerShell
$ $Env:PERCY_TOKEN="<your token here>"
```

## To Execute Test in Percy: 

## Step 1 : Install the @percy/cli
npm install --save-dev @percy/cli

## Step 2 : Execute the Test with below command : 
npx percy exec -- mvn test  

## To Compare 2 URLS to each Other
Set PERCY_BRANCH to Production
PERCY_BRANCH=production npx percy exec -- mvn test

## Compare to the Baseline
Change the URL in TestWebsite.java file

PERCY_BRANCH=staging PERCY_TARGET_BRANCH=production npx percy exec -- mvn test

Verify the Build in Percy




