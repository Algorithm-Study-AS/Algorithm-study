import re

def solution(docs):
    # <main> 태그 내부의 내용만 추출
    docs = docs[len('<main>'):-len('</main>')]

    # title : ...
    docs = re.sub(r'<div +title="([\w ]*)">', r'title : \1\n', docs)

    # 태그 제거
    docs = re.sub(r'</p>', '\n', docs)
    docs = re.sub(r'</?[\w ]*>', '', docs)

    # 앞뒤 공백, 중복 공백 제거
    docs = re.sub(r' ?\n ?', '\n', docs)
    docs = re.sub(r' {2,}', ' ', docs)

    return docs


def main():
    docs = input()
    print(solution(docs))


if __name__ == "__main__":
    main()


# <main><div title="title_name_1"><p>paragraph 1</p><p>paragraph 2 <i>Italic Tag</i> <br > </p><p>paragraph 3 <b>Bold Tag</b> end.</p></div><div title="title_name_2"><p>paragraph 4</p><p>paragraph 5 <i>Italic Tag 2</i> <br > end.</p></div></main>