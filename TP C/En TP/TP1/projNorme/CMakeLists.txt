cmake_minimum_required(VERSION 3.29)
project(untitled C)

set(CMAKE_C_STANDARD 90)
set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall -Wextra -pedantic-errors")

add_executable(untitled main.c)

target_link_libraries(untitled m)
