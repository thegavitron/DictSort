# DictSort
Sort words dictionarically.<br/>
Think you have a bunch of words and you want to sort them in the order how they appear in the dictionary.
## Import
```import gavitron.DictSort;```
***

## Constructors
```DictSort()```<br/>
Constructor don't take any arguments
***
## Methods
```String[] sort(String[] words)```<br/>
returns the Strings that are sorted dictionarically
***
## How to use
#### Writing a Sample Program
```
package myprogram;

public class Sorter{
    public static void main(String[] args){
        var dictsort = new DictSort();
        String[] sortedWords = dictsort.sort(args);
        for(String s: sortedWords){
            System.out.println(s);
        }
    }
}
```
#### Running the Program
```
$ javac myprogram/Sorter
$ java myprogram.Sorter cat apple bus bundle sand app
app
apple
bundle
bus
cat
sand
$ 
```
***
## How it works
Sorting the words dictionarically is not that easy as it seems.
The program have different segments to do the
whole work segmentally instead doing the whole
work on the go. Offcourse, that would be problematic to code.
For ease of concept,  
-An array of String with unordered words are given to the `sort` method.

