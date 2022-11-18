﻿## Table of contents
* [Goal](#goal)
* [General info](#general-info)
* [Design patterns](#design-patterns)

## Goal
Simple java automation framework for testing

## General info
Run from command line: 
mvn   -Dbrowser=chrome -Denvironment=dev 
-DsuiteXml="src/test/resources/testng-smoke.xml" clean test
	
## Design patterns
Project is created with design patterns:
* потокобезопасный Singleton