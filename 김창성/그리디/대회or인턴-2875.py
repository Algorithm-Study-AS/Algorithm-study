#2명의 여학생과 1명의 남학생이 팀을 결성한다
#여학생의 수 N, 남학생의 수 M, 
#인턴쉽에 참여해야하는 인원 K일 때, 최대의 팀 수

if __name__=="__main__":
    women, men, intern = map(int,input().split())
    team=0

    while True:
        women-=2
        men-=1

        if women<0 or men<0 or men+women<intern:
            break
        
        team+=1
    
    print(team)

    

