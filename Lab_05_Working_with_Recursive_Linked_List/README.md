# Lab 5: Working with lists again

```
Goals: The goals of this lab are to practice writing some operations on lists, and working
with lists and loops.
```
# 1 Words in a sentence

```
Goals: To practice representing some data as unions and lists, define operations on it
and also to work with interfaces and abstract classes to refactor code.
```
# 1.1 Introduction

```
A sentence in English is made of several words in a particular sequence. You must
represent such a sentence as a list of words. Much like the lists we saw in class, this one
is made of nodes (represented by a Sentence interface). There is one word per node,
called WordNode. The sentence may also contain zero or more punctuation marks, which
are represented by a PunctuationNode. The end of the sentence is denoted by a special
empty node, called EmptyNode.
```
```
Define the following operations for such a list of words:
```
```
A method getNumberOfWords that computes and returns the number of words in a
sentence. The punctuation does not count as a word.
```
```
A method String longestWord that determines and returns the longest word in a
sentence. The longest word should not begin or end with punctuation.
```
```
A method toString that will convert the sentence into one string. There must be a
space between every two words. There is no space between the last word and the end
of this sentence. If there is no punctuation mark at the end of the sentence, this string
should end with a period (it shouldn’t add the period to the original sentence)
```
```
A method Sentence clone() that returns a duplicate of a given sentence. A duplicate
is a list that has the same words and punctuation in the same sequence, but is
independent of the original list.
```
```
A method Sentence merge(Sentence other) that will merge two sentences into a
single sentence. The merged list should preserve all the punctuation. The merged list
should be returned by this method, and the original lists should be unchanged.
```
# 1.2 What to do

1. Design the interfaces and classes that you need for this purpose.
2. In a JUnit test class, create examples of sentences and write tests for each operation.
3. Design the fields and methods for your classes, and verify that your tests pass on
    them.
4. Check if you need to abstract any common parts of your design/code.

```

