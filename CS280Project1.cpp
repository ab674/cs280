// Abhinav Bassi
// 31327046
// CS 280 102
// Project 1

#include <iostream>
#include <list>

using namespace std;

char othertower(char first, char second) {
    list<char> towers;
    towers.push_back(first);
    towers.push_back(second);
    if (std::find(towers.begin(), towers.end(), 'A') == towers.end()) {
        return 'A';
    }
    else if (std::find(towers.begin(), towers.end(), 'B') == towers.end()) {
        return 'B';
    }
    else {
        return 'C';
    }
}

string generatetemp(char original, int numrepeat) {
    string tempstring = "";
    for (int i = 0; i < numrepeat; i++) {
        tempstring += original;
    }
    return tempstring;
}

void towerofhanoi(string start, string end) {
    int n = (int) start.length();
    if (n != 0) {
        if (start[0] == end[0]) {
            towerofhanoi(start.substr(1), end.substr(1));
        }
        else {
            string temp = generatetemp(othertower(start[0], end[0]), n-1);
            towerofhanoi(start.substr(1), temp);
            cout << "Move disk from " << start[0] << " to " << end[0] << endl;
            towerofhanoi(temp, end.substr(1));
        }
    }
}

int main(int argc, char *argv[]) {
    string start;
    cout << "Enter start configuration: ";
    cin >> start;
    string end;
    cout << "Enter end configuration: ";
    cin >> end;
    towerofhanoi(start, end);
    return 0;
}
