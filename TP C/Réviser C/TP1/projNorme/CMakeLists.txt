cmake_minimum_required(VERSION 3.29)
project(projNorme C)

set(CMAKE_C_STANDARD 90)
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall -Wextra -pedantic-errors")

add_executable(projNorme main.c)
target_link_libraries(projNorme m)