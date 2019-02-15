time=`date +%Y-%m-%d`
filename=/$time.tgz
umount /home/nas
tar cvpzf $filename / --exclude=proc --exclude=/lost+found --exclude=$filename --exclude=/mnt --exclude=/sys
mount -t nfs 10.0.0.3:/volume1/BACKUP32 /home/nas
mv $filename /home/nas
umount /home/nas
