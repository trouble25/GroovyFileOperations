def readFile(filePath) {
    def file = new File(filePath)
    return file.readLines()
}

def analyzeFile(lines) {
    def lineCount = lines.size()
    def wordCount = lines.sum { it.split(/\s+/).size() }
    def charCount = lines.sum { it.size() }

    return [lineCount, wordCount, charCount]
}

def writeResults(outputPath, results) {
    def file = new File(outputPath)
    file.withWriter('UTF-8') { writer ->
        writer.writeLine("Number of lines: ${results[0]}")
        writer.writeLine("Number of words: ${results[1]}")
        writer.writeLine("Number of characters: ${results[2]}")
    }
}

def inputFilePath = args[0] // Path to input text file passed as a command-line argument
def outputFilePath = args[1] // Path to output file passed as a command-line argument

def lines = readFile(inputFilePath)
def results = analyzeFile(lines)
writeResults(outputFilePath, results)
