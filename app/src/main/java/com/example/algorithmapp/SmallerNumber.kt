package com.example.algorithmapp


import kotlin.collections.ArrayList


fun countSmaller(nums: IntArray?): List<Int?>? {
    val res: MutableList<Int?> = ArrayList()
    if (nums == null || nums.isEmpty()) return res
    val root = Node(nums[nums.size - 1])
    res.add(0)
    for (i in nums.size - 2 downTo 0) {
        val count = insertNode(root, nums[i])
        res.add(count)
    }
   return res.also {
       it.reverse()
   }
}

fun insertNode(rootNode: Node, number: Int): Int {
    var root: Node = rootNode
    var thisCount = 0
    while (true) {
        if (number <= root.value) {
            root.count++
            if (root.left == null) {
                root.left = Node(number)
                break
            } else {
                root = root.left!!
            }
        } else {
            thisCount += root.count
            if (root.right == null) {
                root.right = Node(number)
                break
            } else {
                root = root.right!!
            }
        }
    }
    return thisCount
}
class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
    var count = 1

}

fun main() {
    val count = countSmaller(intArrayOf(5,2,6,1))
    count?.forEach {
        println(it)
    }
}