#!/usr/bin/ruby -p
$_.gsub!(/\s\s+/," ") if ($_ =~ /\/\*/)
