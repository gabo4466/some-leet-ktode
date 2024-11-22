package com.gaboscm.problems

class CountNumberOfPossibleRootNodes {
    fun rootCount(edges: Array<IntArray>, guesses: Array<IntArray>, k: Int): Int {
        val response = (0 until edges.size + 1).count { rootNode ->
            checkGuesses(createTreeFromEdges(rootNode, edges.toList()), guesses.toList())>=k }
        return response
    }

    private fun checkGuesses(
        tree: TreeNode,
        guesses: List<IntArray>
    ): Int {
        val childNodes = tree.children.map { it.node }.toSet()
        val correctGuesses = guesses.count { it[0] == tree.node && it[1] in childNodes }
        return correctGuesses + tree.children.sumOf { checkGuesses(it, guesses) }
    }

    private fun createTreeFromEdges(node: Int, edges: List<IntArray>): TreeNode {
        val children = edges.filter { it[0] == node || it[1] == node }.map { if (it[0] == node) it[1] else it[0] }.toIntArray()
        return if (children.isNotEmpty()) TreeNode(node,
            children.map { children -> createTreeFromEdges(children, edges.filter { it[0] != node && it[1] != node }) }
            ) else TreeNode(node, listOf())
    }
    data class TreeNode (
        val node: Int,
        val children: List<TreeNode>
    )
}