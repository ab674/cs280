## Abhinav Bassi
## 31327046
## CS 280 102
## Project 1

def othertower(first, second):
    towers = [first, second]
    if "A" not in towers:
        return "A"
    elif "B" not in towers:
        return "B"
    else:
        return "C"

def towerofhanoi(start, end):
    n = len(start)
    if n == 0:
        pass
    else:
        if start[0] == end[0]:
            towerofhanoi(start[1:], end[1:])
        else:
            temp = othertower(start[0], end[0])
            towerofhanoi(start[1:], temp*(n-1)) 
            print ("Move disk from ", start[0], " to ", end[0]) 
            towerofhanoi(temp*(n-1), end[1:])

def main():
    start = input("Enter start configuration: ")
    end = input("Enter end configuration: ")
    towerofhanoi(start, end)

main()

