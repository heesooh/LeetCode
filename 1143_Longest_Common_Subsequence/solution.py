class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:

        # [0] * (len(text2) + 1): Create an array of 0 of length len(text2)+1
        # for _ in range (len(text1) + 1): Create len(text1)+1 copies of [0]s
        dp_matrix = [[0] * (len(text2) + 1) for _ in range (len(text1) + 1)]

        # Using bottom up dynamic programming approach:
        for col in reversed(range(len(text2))):
            for row in reversed(range(len(text1))):
                if text2[col] == text1[row]:
                    dp_matrix[row][col] = dp_matrix[row+1][col+1]+1
                else:
                    dp_matrix[row][col] = max(dp_matrix[row+1][col], dp_matrix[row][col+1])
                
        return dp_matrix[0][0]

        