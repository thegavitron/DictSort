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
$ javac myprogram/Sorter.java
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
- An input array of String with unordered words are given to the `sort` method.
- `sort` will call `getSuperiorWord` method to determine which word is dictionarically superior.
- then the superior word is saved in an output array and removed from the input array.
- then this work is again performed on the resulted input array until it's all elements are added to output array.
- then the output array is returned
#### Under the hood
To say, all the works are done by `getSuperiorWord` method.
This method returns the most dictionarically superior word out of a bunch of words.
Let's see, how it does so:
- It calls `sortFirstLetter` method to sort the strings according to their first letter. 
- Then another method `predictSuperior` is called to predict which words are eligible for being superior. This returns these words.
- Then with a method `remainVariant` the first letter is stripped of those words and saved in an output character array.
- then the array of stripped word again go through the same process and by time output character array is developed.
- when this process reach the end of a word, the resulted superior word from the output character array is generated and is returned. Obviously this is the most superior word.
***
## Words From The Programmer
The idea of solving this problem is based upon how we sort words ourselves according to dictionary.
At first I wanted to do the whole procedure within a single process but it was getting harder to think and maintain the train of abstract thoughts. Though I was able to develop the program that way, but it looks not organised and also difficult to explain
to someone who isn't myself, Who can't peak inside my head to get the abstract idea. But later, I get this idea of doing this easily in exchange of cpu usage. The previous program was computer friendly but the present one is more tedious but obviously self explanatory and easy to understand the concept. 
After all, I am not a professional coder to think all this stuffs. I did what I wanted to. May be the code is inefficient in some points like converting arrays to arraylists several times. This can slows the program a bit though it is barely observable by our instincts. Now as the main part is done, fixing this 
things isn't a big deal. I will do it gradually. Chill🙆.  
#### Thank you for visiting my program and reading all this messes wrote by a nerd😅

