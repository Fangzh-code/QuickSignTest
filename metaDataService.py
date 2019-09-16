# -*- coding: utf-8 -*-

import os
import json
import sys
reload(sys)
sys.setdefaultencoding('utf-8')

newfile=open('metaData.json','r')
metaData=json.load(newfile)
metaData = json.dumps(metaData)
newfile.close()
