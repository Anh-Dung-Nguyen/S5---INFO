#!/usr/bin/ruby

File.open("source.c", "r") do |file|
  file.each_line do |line|
    puts line if line =~ /\bwhile\b/ #/[a-zA-Z0-9]while[a-zA-Z0-9]
  end
end
