#!/usr/bin/ruby

File.open("source.c", "r") do |file|
  file.each_line do |line|
    puts line if line =~ /^\s*[^a-zA-Z0-9\s]/
  end
end
