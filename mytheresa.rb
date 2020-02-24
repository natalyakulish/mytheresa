puts "Please enter any integer number: "
input = gets.chomp

def is_i?(i)
  i.to_i.to_s == i
end

def is_divisible_by?(n, divider)
  n % divider == 0 if n != 0
end


if is_i?(input)
  number = input.to_i
  result = ""
  result += "my" if is_divisible_by?(number, 3)
  result += "theresa" if is_divisible_by?(number, 5)
  result = number if result.empty?
  puts "Result is #{result}"
else
  puts "#{input} is not an Integer."
end