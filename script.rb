n = 12321
original = n
reversed = 0
while n > 0
    digit = n % 10
    reversed = reversed * 10 + digit
    n = n / 10
end
isPalindrome = 0
if original == reversed
    isPalindrome = 1
end
print 'askskjd'
