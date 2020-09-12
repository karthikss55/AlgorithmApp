//package com.example.algorithmapp
//
//import android.content.ClipData.Item
//
//
//fun calculateSmallerCount(inputArray: IntArray): IntArray {
//    val dataArray = arrayOfNulls<Data>(inputArray.size)
//    for (i in inputArray.indices) {
//        dataArray[i] = Data(i, inputArray[i])
//    }
//    val countArray = intArrayOf()
//    divide(dataArray, 0, dataArray.lastIndex, countArray)
//    return countArray
//}
//
//fun divide(dataArray: Array<Data?>, startIndex: Int, endIndex: Int, countArray: IntArray) {
//    if (startIndex < endIndex) {
//        val middle = (startIndex + (endIndex - startIndex)) / 2
//        divide(dataArray, startIndex, middle, countArray)
//        divide(dataArray, middle + 1, endIndex, countArray)
//        merge(dataArray, startIndex, middle, middle + 1, endIndex, countArray)
//    }
//}
//
//fun merge(
//    inputArray: Array<Data?>,
//    leftStart: Int,
//    leftEnd: Int,
//    rightStart: Int,
//    rightEnd: Int,
//    countArray: IntArray
//) {
//    var incCounter = 0
//    var leftStartIndex = leftStart
//    var rightStartIndex = rightStart
//    while (leftStartIndex <= leftEnd && rightStartIndex <= rightEnd) {
//        if (inputArray[rightStartIndex]?.num!! < inputArray[leftStartIndex]!!.num) {
//            incCounter++
//            rightStartIndex++
//        } else {
//            countArray[inputArray[leftStartIndex]!!.index] += incCounter
//            leftStartIndex++
//        }
//    }
//
//    while (leftStartIndex <= leftStart) {
//        countArray[inputArray[leftStartIndex]!!.index] += incCounter
//        leftStartIndex++
//    }
//    while (rightStartIndex <= rightStart) {
//        countArray[inputArray[rightStartIndex]!!.index] += incCounter
//        rightStartIndex++
//    }
//}
//
//
//fun main() {
//    val data = calculateSmallerCount(intArrayOf(5,2,6,1))
//    data.forEach {
//        println(it)
//    }
//}
//
//data class Data(var index: Int, var num: Int)