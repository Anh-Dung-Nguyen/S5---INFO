cmake_minimum_required(VERSION 3.29)
project(projHistogramme C)

set(CMAKE_C_STANDARD 90)
set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall -Wextra -pedantic-errors")

add_executable(projHistogramme main.c
        tableau.h
        tableau.c)