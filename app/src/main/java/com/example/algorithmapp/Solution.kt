package com.example.algorithmapp

class Solution {

    fun countSmaller(inputArray: IntArray): ArrayList<Int> {
        val len = inputArray.size
        val dataItems = arrayOfNulls<Data>(len)
        for (i in 0 until len) {
            dataItems[i] = Data(inputArray[i], i)
        }
        val countElementsArray = IntArray(len)
        divideAndMerge(dataItems, 0, len - 1, countElementsArray)
        val res: ArrayList<Int> = ArrayList()
        for (i in countElementsArray) {
            res.add(i)
        }
        return res
    }

    /**
     * Function divides and while merging it compares the element and checks the count
     */
    fun divideAndMerge(
        items: Array<Data?>,
        low: Int, high: Int,
        count: IntArray
    ) {
        if (low >= high) {
            return
        }
        val mid = low + (high - low) / 2
        divideAndMerge(items, low, mid, count)
        divideAndMerge(items, mid + 1, high, count)
        merge(items, low, mid, mid + 1, high, count)
    }

    fun merge(
        items: Array<Data?>, low: Int,
        lowEnd: Int, high: Int,
        highEnd: Int, count: IntArray
    ) {
        val m = highEnd - low + 1
        val sortedArray = arrayOfNulls<Data>(m)
        var rightCounter = 0
        var leftIndex = low
        var rightIndex = high
        var index = 0

        while (leftIndex <= lowEnd && rightIndex <= highEnd) {
            if (items[leftIndex]!!.num > items[rightIndex]!!.num) {
                rightCounter++
                sortedArray[index++] = items[rightIndex++]
            } else {
                count[items[leftIndex]!!.index] += rightCounter
                sortedArray[index++] = items[leftIndex++]
            }
        }

        while (leftIndex <= lowEnd) {
            count[items[leftIndex]!!.index] += rightCounter
            sortedArray[index++] = items[leftIndex++]
        }

        while (rightIndex <= highEnd) {
            sortedArray[index++] = items[rightIndex++]
        }
        System.arraycopy(sortedArray, 0, items, low, m)
    }

    fun printArray(countList: ArrayList<Int>) {
        for (i in countList) print("$i ")
        println("")
    }
}

fun main() {
    val solution = Solution()
    val arr = intArrayOf(10, 9, 5, 2, 7, 6, 11, 0, 2)
    val n = arr.size
    arr.let {
        val countList: ArrayList<Int> = solution.countSmaller(it)
        solution.printArray(countList)
    }
}
data class Data(var num: Int, var index: Int)
