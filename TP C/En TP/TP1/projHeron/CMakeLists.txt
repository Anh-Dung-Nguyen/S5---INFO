cmake_minimum_required(VERSION 3.29)
project(projHeron C)

set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall -Wextra -pedantic-errors")
set(CMAKE_C_STANDARD 90)

add_executable(projHeron main.c)

target_link_libraries(projHeron m)