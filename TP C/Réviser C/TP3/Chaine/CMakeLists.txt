cmake_minimum_required(VERSION 3.29)
project(Chaine C)

set(CMAKE_C_STANDARD 90)

add_executable(Chaine main.c
        chaine.h
        login.c)
