cmake_minimum_required(VERSION 3.29)
project(Tache C)

set(CMAKE_C_STANDARD 90)
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall -Wextra -pedantic-errors")

add_executable(Tache main.c
        tache.h
        tache.c
        taches.txt
        liste.h
        liste.c
)
