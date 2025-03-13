#!/usr/bin/ruby

File.open("source.c", "r") do |file|
  file.each_line do |line|
    puts line if line =~ /[a-zA-Z0-9]*\[[0-9]*\]/ #/\b[a-zA-Z]+\w*\[\d+\]/
  end
end
