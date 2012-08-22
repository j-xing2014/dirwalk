#!/usr/bin/env ruby
#
def dirwalk(path)
	total = 0

	Dir.entries(path).each do |entry|
		next if entry == "." || entry == ".."
		fullpath = path + "/" +  entry
		if File.directory?(fullpath)
			total = total + dirwalk(fullpath)
		else
			total = total + 1
		end
	end	
	return total
end

if (ARGV.count == 0)
   puts "Usage: dirwalk.rb DIRECTORY"
   exit
end


puts "Ruby Traversing: #{ARGV[0]}"
total = dirwalk(ARGV[0])
puts "Ruby Total Files: #{total}"
