
list = eval(input("Enter List: "))
print(list)
print(type(list))


l = tuple(range(0,20,2))
print(l)
print(type(l))

s = "Python Automation workflow journey"
l=s.split()
print(l)
print(type(l))


l=["A","B","C","D","E"]
print(l)
x=len(l)
for i in range(x):
    print(l[i], "is available at positive index: ",i," and at negative index: ",i-x)
