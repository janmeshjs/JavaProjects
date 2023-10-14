try{

            img=new ImageIcon(getClass().getResource("/register.png"));
            JLabel imageLabel=new JLabel(img);
            imageLabel.setBounds(200,0,200,600);
            f.add(imageLabel);
        }
        catch (Exception e){
            System.out.println("Image cannot be found!");
        }