#키보드 입력 시간 구하기

keyboard_left={
    'q':(0,0),'w':(0,1),'e':(0,2),'r':(0,3),'t':(0,4),
    'a':(1,0),'s':(1,1),'d':(1,2),'f':(1,3),'g':(1,4),
    'z':(2,0),'x':(2,1),'c':(2,2),'v':(2,3),
}
keyboard_right={
                'y':(0,0),'u':(0,1),'i':(0,2),'o':(0,3),'p':(0,4),
                'h':(1,0),'j':(1,1),'k':(1,2),'l':(1,3),
     'b':(2,-1),'n':(2,0),'m':(2,1)
}

#처음 위치
left_hand,right_hand = input().split()
left_location = keyboard_left[left_hand]
right_location = keyboard_right[right_hand]

#입력할 문자
input_string = input()

count=0
for char in input_string:
    new_location = (-1,-1)
    current_location = (-1,-1)

    if char in keyboard_left: #다음 알파벳 왼손
        new_location=keyboard_left[char]
        current_location=left_location
        left_location=new_location
    else:                       #다음 알파벳 오른손
        new_location=keyboard_right[char]
        current_location=right_location
        right_location=new_location

    count+=abs(new_location[0]-current_location[0]) #x좌표
    count+=abs(new_location[1]-current_location[1]) #y좌표
    count+=1 #누르기

print(count)